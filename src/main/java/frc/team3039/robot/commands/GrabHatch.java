/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team3039.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3039.robot.Robot;

public class GrabHatch extends Command {
  public GrabHatch() {
    requires(Robot.shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.shooter.keepHatch) {
      if(Robot.shooter.getHatchStatus()) {
        Robot.shooter.gripHatch();
        Robot.elevator.isCargoMode = false;
        Robot.shooter.keepHatch = true;
      }

    }
    else {
      Robot.shooter.releaseHatch();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() { 
  }
}