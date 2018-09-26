package uy.edu.um.bbticg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.um.bbticg4.exceptions.InvalidUserInformation;
import uy.edu.um.bbticg4.exceptions.UserAlreadyExists;
import uy.edu.um.bbticg4.persistence.ClienteFinalRepository;
import uy.edu.um.bbticg4.service.entities.ClienteFinal;

@Service
public class ClienteFinalMgr {

    @Autowired
    private ClienteFinalRepository clienteFinalRepository;

    public void addClienteFinal(Integer id, String fName, String lName, String email, String cellphone, String password)
            throws UserAlreadyExists, InvalidUserInformation {

        if(id == null || fName == null || fName == null || "".equals(fName)|| "".equals(id) || "".equals(fName)){
            throw new InvalidUserInformation();
        }

        if(clienteFinalRepository.existsById(id)){
            throw new UserAlreadyExists();
        }

        clienteFinalRepository.save(new ClienteFinal(id, fName, lName, email, cellphone, password));
    }
}
