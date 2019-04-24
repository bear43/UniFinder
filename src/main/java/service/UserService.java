package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService
{
    private final UserRepository userRepository;

    private User currentUser;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User getCurrentUserByLogin(String username)
    {
        return userRepository.findByName(username);
    }

    public User getCurrentUserByLogin()
    {
        return getCurrentUserByLogin((String)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public void fillCurrentUser(String username)
    {
        currentUser = getCurrentUserByLogin(username);
    }

    public void fillCurrentUser()
    {
        currentUser = getCurrentUserByLogin();
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }

    public UserRepository getUserRepository()
    {
        return userRepository;
    }

    public void saveAndFlush()
    {
        userRepository.saveAndFlush(currentUser);
    }
}
