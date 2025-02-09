package com.example.service

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        try {
            println("WorkManagerResult: Work is Running!")
            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }
    }
}