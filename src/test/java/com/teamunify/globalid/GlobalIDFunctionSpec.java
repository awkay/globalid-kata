package com.teamunify.globalid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import gnu.trove.set.TLongSet;
import gnu.trove.set.hash.TLongHashSet;
import java.util.Calendar;
import org.junit.Test;
import com.teamunify.time.Times;
import com.teamunify.util.Function0;

public class GlobalIDFunctionSpec {

  @Test
  public void extends_function0_so_it_can_be_used_in_factories() {
    @SuppressWarnings("unused")
    final Function0<Long> unusedVariable = new GlobalIDFunction();
  }
  
  @Test
  public void generates_identity_based_on_system_time() throws InterruptedException {
    final Calendar testNow = Calendar.getInstance();
    Times.now.set(Function0.functionReturningValue(testNow));
    Function0<Long> generator = new GlobalIDFunction();
    
    Thread.sleep(10);

    assertEquals(testNow.getTimeInMillis(), generator.apply().longValue());
  }
  
  @Test
  public void identities_are_unique() {
    final TLongSet idsGenerated = new TLongHashSet();
    Function0<Long> generator = new GlobalIDFunction();
    final int aLotOfIDs = 10000;
    
    for(int i=0; i<aLotOfIDs; i++) {
      long id = generator.apply().longValue();
      assertFalse(id + " was generated twice", idsGenerated.contains(id));
      idsGenerated.add(id);
    }
  }
}
