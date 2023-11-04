package Dao;

import Entity.Utilisateur;

import java.util.List;

public interface UserDao {

    Utilisateur getUser(String id);

    List<Utilisateur> getAllusers();


}
