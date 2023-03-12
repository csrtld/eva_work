package com.example.users;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository userRepository;

    private final PhonesRepository phonesRepository;

    public UsersService(UsersRepository usersRepository, PhonesRepository phonesRepository) {
        this.userRepository = usersRepository;
        this.phonesRepository = phonesRepository;
    }

    private void validateUserInput(User user) {
        if (!Helper.validaMail(user.getMail())) {
            throw new IllegalArgumentException("Email con formato incorrecto (Ejemplo correo@dominio.cl)");
        }
        if(!Helper.validaPassword(user.getPassword())) {
            throw new IllegalArgumentException("Contraseña debe contener 4 a 8 caracteres, números y letras minúsculas y mayúsculas.");
        }
    }

    public User updateUser(User user, Long id) {
        validateUserInput(user);
        this.getUserById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public User createUser(User user) {
        validateUserInput(user);
        boolean empty = userRepository
                .findByMail(user.getMail())
                .isEmpty();
        if (empty) {
            return userRepository.save(user);
        }
        throw new MailExistException(user.getMail());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(UserDoesntExistException::new);
    }

}
