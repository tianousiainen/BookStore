package homework.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import homework.bookstore.domain.Category;
import homework.bookstore.domain.CategoryRepository;


@DataJpaTest 
public class CategoryRepositoryTest {

    @Autowired 
    private CategoryRepository cRepository;

    private Category testCategory;

    @BeforeEach
    public void Setup(){
        testCategory = cRepository.save(
            new Category("Test category")
        );
    }

    @Test
    public void createNewCategory(){
        Category category = cRepository.save(
            new Category("Test category")
        );

        cRepository.save(category);

        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void findCategoryId(){
        Optional<Category> found = cRepository.findById(testCategory.getCategoryid());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Test category");
    }

    @Test
    public void deleteCategory(){
        cRepository.deleteById(testCategory.getCategoryid());

        assertThat(cRepository.findById(testCategory.getCategoryid())).isEmpty();
    }
}
