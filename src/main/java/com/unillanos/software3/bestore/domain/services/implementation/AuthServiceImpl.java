package com.unillanos.software3.bestore.domain.services.implementation;

import com.unillanos.software3.bestore.domain.model.entities.Customer;
import com.unillanos.software3.bestore.domain.model.entities.Enterprise;
import com.unillanos.software3.bestore.domain.model.entities.Person;
import com.unillanos.software3.bestore.domain.model.entities.User;
import com.unillanos.software3.bestore.domain.model.enums.Role;
import com.unillanos.software3.bestore.domain.services.interfaces.AuthService;
import com.unillanos.software3.bestore.infraestructure.repositories.AdminRepo;
import com.unillanos.software3.bestore.infraestructure.repositories.CustomerRepo;
import com.unillanos.software3.bestore.infraestructure.repositories.EnterpriseRepo;
import com.unillanos.software3.bestore.infraestructure.repositories.UserRepo;
import com.unillanos.software3.bestore.web.security.config.JwtService;
import com.unillanos.software3.bestore.web.transfer.dto.user.UserDTO;
import com.unillanos.software3.bestore.web.transfer.request.LastStepRequest;
import com.unillanos.software3.bestore.web.transfer.responses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final EnterpriseRepo enterpriseRepo;
    private final CustomerRepo costumerRepo;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(UserDTO request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        if (userRepo.existsById(request.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        try {
            userRepo.save(user);
        } catch (Exception e) {
            log.error("Error saving user", e);
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(UserDTO request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getUpdateDate() == null) {
            try {
                response.setStatus(200);
                response.sendRedirect("http://127.0.0.1:5500/templates/userSelection.html?email="+request.getEmail());
            } catch (Exception e) {
                throw new RuntimeException("Error redirect");
            }
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public boolean lastStep(LastStepRequest request, HttpServletResponse response) {
        User user = userRepo.findByEmail(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUpdateDate(LocalDate.now());
        System.out.println(request.getEnterprise());
        if (request.getEnterprise() == null || request.getEnterprise().getNit().isEmpty()) {
            Person person = Person.builder()
                    .id(request.getPerson().getId())
                    .name(request.getPerson().getName())
                    .lastName(request.getPerson().getLastName())
                    .phone(request.getPerson().getPhone())
                    .build();

            Customer costumer = new Customer();

            costumer.setUser(user);
            costumer.setPerson(person);

            try {
                costumerRepo.save(costumer);
                return true;
            } catch (Exception e) {
                log.error("Error saving user", e);
                throw new RuntimeException("Error saving user");
            }

        } else {

            user.setRole(Role.ENTERPRISE);

            Enterprise enterprise = Enterprise.builder()
                    .nit(request.getEnterprise().getNit())
                    .name(request.getEnterprise().getName())
                    .location(request.getEnterprise().getLocation())
                    .phone(request.getEnterprise().getPhone())
                    .imagePath(request.getEnterprise().getImagePath())
                    .build();


            Person person = Person.builder()
                    .id(request.getPerson().getId())
                    .name(request.getPerson().getName())
                    .lastName(request.getPerson().getLastName())
                    .phone(request.getPerson().getPhone())
                    .build();

            enterprise.setPerson(person);
            enterprise.setUser(user);

            try {
                enterpriseRepo.save(enterprise);
                return true;
            } catch (Exception e) {
                log.error("Error saving enterprise", e);
            }


        }
        throw new RuntimeException("Error saving user");
    }

    @Override
    public User getUser() {
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        if (userRepo.existsByEmail(((User) authToken.getPrincipal()).getEmail())) {
            User user = userRepo.findByEmail(((User) authToken.getPrincipal()).getEmail()).get();
            return user;
        }
        return null;
    }

}