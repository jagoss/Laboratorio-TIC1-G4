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

    public void addClienteFinal(String fName, String lName, String email, String confEmail, String cellphone,
                                String password, String confPass)
            throws UserAlreadyExists, InvalidUserInformation {

        if(fName == null    ||  "".equals(fName)
                || lName == null    ||  "".equals(lName)
                || cellphone == null    ||  "".equals(cellphone)
                || password == null     ||  "".equals(password)
                || confEmail == null     ||  "".equals(confEmail)
                || confPass == null     ||  "".equals(confPass)
                || !email.equals(confEmail) || !password.equals(confPass)){
            throw new InvalidUserInformation();
        }

        if(clienteFinalRepository.existsByEmailOrCellphone(email, cellphone)){
            throw new UserAlreadyExists();
        }

        clienteFinalRepository.save(new ClienteFinal(fName, lName, email, cellphone, password));
    }

    public boolean loginCorrecto(String email, String password){
        if(email == null || password == null ){
            return false;
        }
        return clienteFinalRepository.existsByEmailAndPassword(email, password);
    }

    public boolean EmailExists(String email){ return clienteFinalRepository.existsByEmail(email); }

    public ClienteFinal getCliente(String email){
        return clienteFinalRepository.findClienteFinalByEmail(email);
    }

    public ClienteFinal getClienteById(Integer id) { return  clienteFinalRepository.findClienteFinalById(id);}

}
