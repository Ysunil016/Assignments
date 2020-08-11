package com.Spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.VotedHistory;

public interface VotingHistoryRepository extends CrudRepository<VotedHistory, String> {

}
