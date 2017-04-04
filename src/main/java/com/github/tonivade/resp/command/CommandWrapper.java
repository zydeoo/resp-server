/*
 * Copyright (c) 2015-2017, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package com.github.tonivade.resp.command;

import static com.github.tonivade.resp.protocol.RedisToken.error;

import com.github.tonivade.resp.annotation.ParamLength;
import com.github.tonivade.resp.protocol.RedisToken;

public class CommandWrapper implements ICommand {

  private int params;

  private final ICommand command;

  public CommandWrapper(ICommand command) {
    this.command = command;
    ParamLength length = command.getClass().getAnnotation(ParamLength.class);
    if (length != null) {
      this.params = length.value();
    }
  }

  @Override
  public RedisToken<?> execute(IRequest request) {
    if (request.getLength() < params) {
      return error("ERR wrong number of arguments for '" + request.getCommand() + "' command");
    }
    return command.execute(request);
  }
}
