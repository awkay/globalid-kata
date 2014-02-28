package com.teamunify.globalid;

import com.teamunify.time.Times;
import com.teamunify.util.Function0;

public class GlobalIDFunction extends Function0<Long> {
  private long lastIDGenerated = 0L;

  @Override
  public Long apply() {
    long proposedID = Times.now.make().getTimeInMillis();
    if(lastIDGenerated >= proposedID)
      proposedID = lastIDGenerated + 1;
    lastIDGenerated = proposedID;
    return proposedID;
  }

}
