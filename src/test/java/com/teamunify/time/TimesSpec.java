package com.teamunify.time;

import static org.junit.Assert.*;
import java.util.Calendar;
import org.junit.Test;
import com.teamunify.factory.Factory;

public class TimesSpec {
  @Test
  public void has_a_factory_for_building_now() {
    assertTrue(Times.now instanceof Factory);
  }

  @Test
  public void the_now_factory_has_default_builder_of_Calendar_getInstance() {
    Times.now.resetToDefault();
    Calendar almostNow = Calendar.getInstance();
    assertTrue(almostNow.getTimeInMillis() <= Times.now.make().getTimeInMillis());
  }
}
