/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */

package tonivade.redis.command.server;

import static tonivade.redis.protocol.SafeString.safeString;

import org.junit.Rule;
import org.junit.Test;

import tonivade.redis.command.CommandRule;
import tonivade.redis.command.CommandUnderTest;

@CommandUnderTest(EchoCommand.class)
public class EchoCommandTest {

    @Rule
    public final CommandRule rule = new CommandRule(this);

    @Test
    public void testExecute() {
        rule.withParams("test")
            .execute()
            .verify().addBulkStr(safeString("test"));
    }

}
