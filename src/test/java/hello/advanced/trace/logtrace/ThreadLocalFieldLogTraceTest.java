package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalFieldLogTraceTest {

    ThreadLocalFieldLogTrace fieldLogTrace = new ThreadLocalFieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = fieldLogTrace.begin("hello1");
        TraceStatus status2 = fieldLogTrace.begin("hello2");
        fieldLogTrace.end(status2);
        fieldLogTrace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = fieldLogTrace.begin("hello1");
        TraceStatus status2 = fieldLogTrace.begin("hello2");
        fieldLogTrace.exception(status2, new IllegalStateException());
        fieldLogTrace.exception(status1, new IllegalStateException());
    }

}