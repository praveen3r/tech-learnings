/*package com.demo.subscriber;

public class ForwardSubscriber {

	@KafkaListener(topics = "annotated21")
	@SendTo("!{request.value()}") // runtime SpEL
	public String replyingListener(String in) {
	}

	@KafkaListener(topics = "${some.property:annotated22}")
	@SendTo("#{myBean.replyTopic}") // config time SpEL
	public Collection<String> replyingBatchListener(List<String> in) {
	}

	@KafkaListener(topics = "annotated23", errorHandler = "replyErrorHandler")
	@SendTo("annotated23reply") // static reply topic definition
	public String replyingListenerWithErrorHandler(String in) {
	}
	
	@KafkaListener(topics = "annotated25")
	@SendTo("annotated25reply1")
	public class MultiListenerSendTo {

	    @KafkaHandler
	    public String foo(String in) {
	    }

	    @KafkaHandler
	    @SendTo("!{'annotated25reply2'}")
	    public String bar(@Payload(required = false) KafkaNull nul,
	            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) int key) {
	    }

	}
	
	@KafkaListener(id = "voidListenerWithReplyingErrorHandler", topics = "someTopic",
	        errorHandler = "voidSendToErrorHandler")
	@SendTo("failures")
	public void voidListenerWithReplyingErrorHandler(String in) {
	    throw new RuntimeException("fail");
	}
	
	@Bean
	public KafkaListenerErrorHandler voidSendToErrorHandler() {
	    return (m, e) -> {
	        return ... // some information about the failure and input data
	    };
	}	
	
}
*/

