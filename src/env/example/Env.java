package example;

// Environment code for project traffic

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;

import java.util.logging.*;

public class Env extends Environment {

    private Logger logger = Logger.getLogger("traffic."+Env.class.getName());

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
        try {
            addPercept(ASSyntax.parseLiteral("location(robot,lane1)"));
            addPercept(ASSyntax.parseLiteral("location(waste,lane1)"));
            addPercept(ASSyntax.parseLiteral("location(bin,lane5)"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action+", but not implemented!");
        
        try {
            if(action.getFunctor().equals("pick")){
                removePercept(ASSyntax.parseLiteral("location(waste,lane1)"));
                addPercept(ASSyntax.parseLiteral("location(waste,robot)"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }


    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}
