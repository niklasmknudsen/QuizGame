package dk.howard.service;


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
/*
@Transactional(rollbackOn = Exception.class)
@Dependent
public class Service {

    private final Repository repository;

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void createUser(Name name) {
        repository.createUser(name);
    }

    public User findByName(Name name) {
        return repository.findUserByName(name);
    }

}
*/