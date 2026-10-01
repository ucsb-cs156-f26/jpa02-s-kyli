package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.beans.Transient;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team"); 
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void equals_test(){
        ArrayList<String>wrongNames = new ArrayList<String>()
            {{add("Jason"); add("Lucy"); add("Mia"); add("Serena"); add("Sonny");}};
        
        assertFalse(team.equals(1),"team equals an integer?");
        assertTrue(team.equals(team),"team not equals itself????");

        Team otherTeam = new Team("test-team");
        assertTrue(team.equals(otherTeam),"team should be equal to other identical team");

        otherTeam.setName("other-team");
        assertFalse(team.equals(otherTeam),"team should not be equal to other not identical team (wrong: name only)");

        otherTeam.setName("test-team");
        otherTeam.setMembers(wrongNames);
        assertFalse(team.equals(otherTeam),"team should not be equal to other not identical team (wrong: team members only)");

        otherTeam.setName("other-team");
        assertFalse(team.equals(otherTeam),"team should not be equal to other not identical team (wrong: team members and name)");
    }

    @Test
    public void test_toString(){
        assertEquals(team.toString(),"Team(name=test-team, members=[])");
    }

    @Test
    public void test_hashCode(){
        Team team1 = new Team("test-team");
        team1.addMember("hi");
        Team team2 = new Team("test-team");
        team2.addMember("hi");

        assertEquals(team1.hashCode(),team2.hashCode());                
    }

    @Test
    public void test_hashCode_mutation(){
        Team t1 = new Team();
        int result = t1.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult,result);
    }
}
