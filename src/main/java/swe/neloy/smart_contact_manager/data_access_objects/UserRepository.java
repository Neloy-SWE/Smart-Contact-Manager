/* 
Created by Neloy on 10 August, 2025.
Email: taufiqneloy.swe@gmail.com
*/

package swe.neloy.smart_contact_manager.data_access_objects;

import org.springframework.data.jpa.repository.JpaRepository;
import swe.neloy.smart_contact_manager.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
