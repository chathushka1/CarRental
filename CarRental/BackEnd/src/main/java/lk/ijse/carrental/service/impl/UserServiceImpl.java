package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.UserDTO;
import lk.ijse.carrental.entity.User;
import lk.ijse.carrental.repo.UserRepo;
import lk.ijse.carrental.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:15
 * 2023-10-29
 * FrontEnd
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveUser(UserDTO usersDTO) {
        if (!userRepo.existsById(usersDTO.getUserId())){
            userRepo.save(mapper.map(usersDTO, User.class));
        }

    }

    @Override
    public void updateUser(UserDTO usersDTO) {
        if(userRepo.existsById(usersDTO.getUserId())){
            userRepo.save(mapper.map(usersDTO, User.class));
        }else{
            throw new RuntimeException(usersDTO.getUserId()+"No Please Check The Correct Id..!");
        }
    }

    @Override
    public void deleteUser(String id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
        }else{
            throw new RuntimeException(id+"No Please Check The Correct Id..!");
        }
    }

    @Override
    public UserDTO searchUser(String id) {
        if(userRepo.existsById(id)){
            User users = userRepo.findById(id).get();
            return mapper.map(users, UserDTO.class);
        }else {
            throw new RuntimeException(id+"No Please Check The Correct Id..!");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all=userRepo.findAll();
        return mapper.map(all,new TypeToken<List<UserDTO>>(){}.getType());
    }

    @Override
    public String generateUserIds() {
        return userRepo.generateUserId();
    }

    @Override
    public UserDTO findByPasswordAndUsername(String password, String username) {
        User users = userRepo.findByPasswordAndUsername(password, username);
        return mapper.map(users, UserDTO.class);
    }

    @Override
    public UserDTO findByUsername(String username) {
        User users = userRepo.findByUsername(username);
        return mapper.map(users, UserDTO.class);
    }
}
