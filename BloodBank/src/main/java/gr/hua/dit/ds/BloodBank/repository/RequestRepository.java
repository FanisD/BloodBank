package gr.hua.dit.ds.BloodBank.repository;

import gr.hua.dit.ds.BloodBank.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
}
