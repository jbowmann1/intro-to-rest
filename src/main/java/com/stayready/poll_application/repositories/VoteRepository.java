package com.stayready.poll_application.repositories;

import com.stayready.poll_application.domain.Option;
import com.stayready.poll_application.domain.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    @Query(value = "SELECT v.* " +
            "FROM Option o, Vote v " +
            "WHERE o.POLL_ID = ?1 " +
            "AND v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
    Iterable<Vote> findVotesByPoll(Long pollId);

    Iterable<Vote> findById(Long pollId);
}
