package example;

import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.environment.Environment;

public class Env extends Environment {
    String robotLocation = "lane1";
    String binLocation = "lane5";
    String wasteLocation = "lane1";

    @Override
    public void init(String[] args) {
        // initial percepts
        addPercept(Literal.parseLiteral("location(robot,lane1)"));
        addPercept(Literal.parseLiteral("location(bin,lane5)"));
        addPercept(Literal.parseLiteral("location(waste,lane1)"));
    }

    /**
     * Implementation of the agent's basic actions
     */
    @Override
    public boolean executeAction(String ag, Structure act) {
        System.out.println("Agent "+ag+" is doing "+act);

        if (act.getFunctor().equals("pick")) {
            wasteLocation = "robot";
            removePercept(Literal.parseLiteral("location(waste,lane1)"));
            addPercept(Literal.parseLiteral("location(waste,robot)"));
        }

        else if (act.getFunctor().equals("move")) {
            removePercept(Literal.parseLiteral("location(robot,"+robotLocation+")"));
            robotLocation = act.getTerm(1).toString();
            addPercept(Literal.parseLiteral("location(robot,"+act.getTerm(1).toString()+")"));
        }

        else if (act.getFunctor().equals("drop")) {
            removePercept(Literal.parseLiteral("location(waste,"+wasteLocation+")"));
            wasteLocation = null;
            System.out.println("Waste dropped in the bin");
        }
            
        return true;
    }

}

