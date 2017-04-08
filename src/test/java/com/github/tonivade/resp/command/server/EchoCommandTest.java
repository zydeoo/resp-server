/*
 * Copyright (c) 2015-2017, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.resp.command.server;

import static com.github.tonivade.resp.protocol.RedisToken.string;

import org.junit.Rule;
import org.junit.Test;

import com.github.tonivade.resp.command.CommandRule;
import com.github.tonivade.resp.command.CommandUnderTest;

@CommandUnderTest(EchoCommand.class)
public class EchoCommandTest {
  @Rule
  public final CommandRule rule = new CommandRule(this);

  @Test
  public void testExecute() {
    rule.withParams("test")
        .execute()
        .assertThat(string("test"));
  }
}
