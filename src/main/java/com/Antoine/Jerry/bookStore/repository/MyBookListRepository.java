package com.Antoine.Jerry.bookStore.repository;

import com.Antoine.Jerry.bookStore.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookListRepository extends JpaRepository<MyBookList, Integer> {
}
