package com.example.hackathonendava.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private UserInfo userInfo;

    public List<User> getAllUsers() { return (List<User>) userRepository.findAll(); }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new UserInfo(user);
    }

    public void updateUserProfilePicture(String image, String email) {
        User user = userRepository.getUserByEmail(email);
        user.setProfile_image(image);
        userRepository.save(user);
    }


}
