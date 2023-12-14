package string.decode.memory.consumption

import org.reactivestreams.Publisher
import org.springframework.core.ResolvableType
import org.springframework.core.codec.StringDecoder
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.buffer.DataBuffer
import org.springframework.core.io.buffer.DefaultDataBufferFactory
import reactor.core.publisher.Flux
import java.nio.charset.Charset
import kotlin.test.Test

class Test {
    @Test fun appHasAGreeting() {
        val data = ClassPathResource("data.txt").inputStream.bufferedReader().readText()
        val buffer: Publisher<DataBuffer> = Flux.just(
            DefaultDataBufferFactory.sharedInstance.wrap(data.toByteArray(
                Charset.forName("UTF-8"))))
        StringDecoder.textPlainOnly().decode(buffer, ResolvableType.forClass(String::class.java), null, null).subscribe {
            println(it)
        }
    }
}
