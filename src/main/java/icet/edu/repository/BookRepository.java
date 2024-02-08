package icet.edu.repository;

import icet.edu.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity,Long> {
}
