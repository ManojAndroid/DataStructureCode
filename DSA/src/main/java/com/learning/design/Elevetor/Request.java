package com.learning.design.Elevetor;

public class Request implements Comparable<Request> {

    ExternalRequest externalRequest;
    InternalRequest internalRequest;

    public Request(ExternalRequest externalRequest,
                   InternalRequest internalRequest) {
        this.externalRequest = externalRequest;
        this.internalRequest = internalRequest;
    }

    public ExternalRequest getExternalRequest() {
        return externalRequest;
    }

    public void setExternalRequest(ExternalRequest externalRequest) {
        this.externalRequest = externalRequest;
    }

    public InternalRequest getInternalRequest() {
        return internalRequest;
    }

    public void setInternalRequest(InternalRequest internalRequest) {
        this.internalRequest = internalRequest;
    }

    @Override
    public int compareTo(Request req) {
        return this.getInternalRequest().getDestinationFloor() - req.getInternalRequest()
                .getDestinationFloor();

    }
}
