/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodlamaio.northwind.core.dataAccess;

import kodlamaio.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oguz.turkaslan
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
