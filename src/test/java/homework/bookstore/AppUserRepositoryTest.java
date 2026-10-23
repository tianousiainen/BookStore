package homework.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import homework.bookstore.domain.AppUser;
import homework.bookstore.domain.AppUserRepository;


@DataJpaTest 
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository aRepository;

    private AppUser testAppUser;

    @BeforeEach
    public void setUp(){
        testAppUser = aRepository.save(
            new AppUser ("newuser", 
                    "newhas", "newuser@test.com", "ADMIN")
        );
    }

    @Test
    public void createNewUser(){
        AppUser appUser = new AppUser("testuser", 
                    "testhas", "testuser@test.com", "ADMIN");

        aRepository.save(appUser);

        assertThat(appUser.getId()).isNotNull();
    }

    @Test
    public void findUser(){
        Optional<AppUser> found = aRepository.findById(testAppUser.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getUsername()).isEqualTo("newuser");
    }

    @Test
    public void deleteUser(){
        aRepository.deleteById(testAppUser.getId());

        assertThat(aRepository.findById(testAppUser.getId())).isEmpty();
    }
}
