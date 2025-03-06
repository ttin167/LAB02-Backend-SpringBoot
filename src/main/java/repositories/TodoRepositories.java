package org.example.lab02.repositories;

import org.example.lab02.pojos.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepositories extends JpaRepository<Todo, Long> {
}
