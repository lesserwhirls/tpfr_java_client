package com.spectralogic.tpfr.client.model;

import com.spectralogic.tpfr.api.response.OffsetsStatusResponse;

public class OffsetsStatus {

    private final OffsetsResult offsetsResult;

    private final String inBytes;

    private final String outBytes;

    public OffsetsStatus(final OffsetsStatusResponse offsetsStatusResponse) {
        offsetsResult = getOffsetsResult(offsetsStatusResponse.getOffsetsResult());
        inBytes = offsetsStatusResponse.getInBytes();
        outBytes = offsetsStatusResponse.getOutBytes();
    }

    public OffsetsResult getOffsetsResult() {
        return offsetsResult;
    }

    public String getInBytes() {
        return inBytes;
    }

    public String getOutBytes() {
        return outBytes;
    }

    private OffsetsResult getOffsetsResult(final String result)
    {
        switch (result)
        {
            case "Succeeded":
                return OffsetsResult.Succeeded;
            case "Error File Not Found":
                return OffsetsResult.ErrorFileNotFound;
            default:
                return OffsetsResult.Unknown;
        }
    }
}
