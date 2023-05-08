package com.example.ecommersmanagement.service;

import com.example.ecommersmanagement.dto.response.ResponseDto;
import com.example.ecommersmanagement.dto.user.SignInDto;
import com.example.ecommersmanagement.dto.user.SignInResponseDto;
import com.example.ecommersmanagement.dto.user.SignUpDto;
import com.example.ecommersmanagement.entity.AuthenticationToken;
import com.example.ecommersmanagement.entity.User;
import com.example.ecommersmanagement.exception.AuthenticationFailException;
import com.example.ecommersmanagement.exception.CustomException;
import com.example.ecommersmanagement.repository.UserRepository;
import com.example.ecommersmanagement.service.inter.UserServiceInter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInter {
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    @Override
    @Transactional
    public ResponseDto signUp(SignUpDto signUpDto) {


        //checking user's account is present
        if (Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail()))) {
            throw new CustomException("user already exist");

        }
        String encryptedPassword = signUpDto.getPassword();
        try {
            encryptedPassword = hashPassword(signUpDto.getPassword());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //Save User
        User user = new User(signUpDto.getFirstName(), signUpDto.getLastName(), signUpDto.getEmail(), encryptedPassword);
        userRepository.save(user);

final AuthenticationToken authenticationToken=new AuthenticationToken(user);
authenticationService.saveConfirmationToken(authenticationToken);



//response message
        ResponseDto responseDto = new ResponseDto("success", "user created succesfully");
        return responseDto;
    }

    //encryption for password
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }
    public SignInResponseDto signIn(SignInDto signInDto) {
        User user = userRepository.findByEmail(signInDto.getEmail());
        if (Objects.isNull(user)) {
            throw new AuthenticationFailException("User does not exist");
        }
       try {
           if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
               throw new AuthenticationFailException("Wrong Password");
           }
       }catch (NoSuchAlgorithmException e){
           e.printStackTrace();
       }


AuthenticationToken token=authenticationService.getToken(user);
       if(Objects.isNull(token)){
           throw new CustomException("Token is not present");
       }
       return new SignInResponseDto("success",token.getToken());

    }
}