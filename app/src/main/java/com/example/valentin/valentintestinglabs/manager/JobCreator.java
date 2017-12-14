package com.example.valentin.valentintestinglabs.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;

/**
 * Created by valentin on 12/12/2017.
 */

public class JobCreator implements com.evernote.android.job.JobCreator {
    @Nullable
    @Override
    public Job create(@NonNull String tag) {
        switch (tag) {
            case InsertJob.TAG:
                return new InsertJob();
            case SelectJob.TAG:
                return new SelectJob();
            default:
                return null;
        }
    }
}
