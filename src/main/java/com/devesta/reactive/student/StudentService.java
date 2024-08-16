package com.devesta.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Flux<Student> findAllByAge(Integer age) {
        return repository.findAllByAge(age);
    }

    public Flux<Student> findAll() {
        return repository.findAll().delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Integer id) {
        return repository.findById(id);
    }

    public Mono<Student> save(Student student) {
        return repository.save(student);
    }

}
