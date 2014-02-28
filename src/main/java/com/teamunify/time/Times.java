package com.teamunify.time;

import java.util.Calendar;
import com.teamunify.factory.Factory;
import com.teamunify.util.Function0;

public class Times {
  private static final Function0<Calendar> systemTimeBuilder = new Function0<Calendar>() {
    @Override
    public Calendar apply() {
      return Calendar.getInstance();
    }};

  public static final Factory<Calendar> now = new Factory<Calendar>(systemTimeBuilder);
}
