package com.wurmonline.server.behaviours;

import java.lang.reflect.InvocationTargetException;

import org.gotti.wurmunlimited.modloader.ReflectionUtil;
import org.gotti.wurmunlimited.modsupport.vehicles.ModVehicleBehaviour;

import com.wurmonline.server.behaviours.Seat;
import com.wurmonline.server.behaviours.Vehicle;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;

/**
 * Created by neko on 11/08/16.
 */
public class BehaviourAccessor extends ModVehicleBehaviour {
    public Seat getSeat(byte type) {
        //return new Seat(type);
    	return createSeat(type);
    }

    public void setMaxSpeed (Vehicle v, float speed) {
        //v.setMaxSpeed(speed);
        try {
			ReflectionUtil.callPrivateMethod(v, ReflectionUtil.getMethod(v.getClass(), "setMaxSpeed"), speed);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
    }
    public void setMaxDepth(Vehicle v, float depth) {
        //v.setMaxDepth(depth);
        try {
			ReflectionUtil.callPrivateMethod(v, ReflectionUtil.getMethod(v.getClass(), "setMaxDepth"), depth);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
    }

    public void setMaxHeight(Vehicle v, float height) {
        //v.setMaxHeight(height);
        try {
			ReflectionUtil.callPrivateMethod(v, ReflectionUtil.getMethod(v.getClass(), "setMaxHeight"), height);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
    }

    public void setSkillNeeded(Vehicle v, float skill) {
        //v.setSkillNeeded(skill);
        try {
			ReflectionUtil.callPrivateMethod(v, ReflectionUtil.getMethod(v.getClass(), "setSkillNeeded"), skill);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
    }
    public void setMaxHeightDiff(Vehicle v, float heightdiff){
        //v.setMaxHeightDiff(heightdiff);
        try {
			ReflectionUtil.callPrivateMethod(v, ReflectionUtil.getMethod(v.getClass(), "setMaxHeightDiff"), heightdiff);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
    }

    public void setEmbarkString(Vehicle v, String s) {
        //v.setEmbarkString(s);
        try {
			ReflectionUtil.callPrivateMethod(v, ReflectionUtil.getMethod(v.getClass(), "setEmbarkString"), s);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
    }
    public void setPilotName(Vehicle v, String s) {
        //v.setPilotName(s);
        try {
			ReflectionUtil.callPrivateMethod(v, ReflectionUtil.getMethod(v.getClass(), "setPilotName"), s);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void setSettingsForVehicle(Creature creature, Vehicle vehicle) {
		//
	}

	@Override
	public void setSettingsForVehicle(Item item, Vehicle vehicle) {
		//
	}

    /*
      vehicle.setMaxDepth(maxDepth);
        vehicle.setMaxHeight(maxHeight);
        vehicle.setMaxHeightDiff(maxHeightDiff);
        vehicle.setSkillNeeded(skillNeeded);

     */
}
