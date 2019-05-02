
package com.springcloudkafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputSource {

    String OUTPUT = "output";

    @Output(OUTPUT)
    MessageChannel outputMessageChannel();

}
