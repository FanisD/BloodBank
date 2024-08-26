package gr.hua.dit.ds.BloodBank.repository;

import gr.hua.dit.ds.BloodBank.entity.BloodTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodTestRepository extends JpaRepository<BloodTest, Integer> {
}