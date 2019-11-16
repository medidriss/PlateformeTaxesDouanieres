package com.enit.metiersImplemtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enit.dao.SimulationRepository;
import com.enit.dao.UserRepository;
import com.enit.entites.Simulation;
import com.enit.entites.User;
import com.enit.metiers.SimulationMetier;
import com.enit.metiers.UserMetier;

@Component
public class UserMetierImpl implements UserMetier {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SimulationRepository simulationRepository;

    @Override
    public List<User> consulterLesUsers() {
        return userRepository.findAll();
    }

    @Override
    public User consulterUser(String idUser) {
        try {
            return userRepository.findById(idUser).get();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public boolean ajouterUser(User user) {
        try {
            if (user != null) {
                userRepository.save(user);
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean supprimerUser(String username) {
        try {
            if (userRepository.existsById(username)) {
                User user = userRepository.findById(username).get();
                user.supprimerUser();
                return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }


    @Override
    public boolean modifierUser(String username, User user) {
        try {
            if (userRepository.existsById(username)) {
                User u = consulterUser(username);
                u = user;
                userRepository.save(u);
                return true;
            }


        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }


}
