package dev.murugi.workoutlog.api

import dev.murugi.workoutlog.models.LoginRequest
import dev.murugi.workoutlog.models.LoginResponse
import dev.murugi.workoutlog.models.RegisterRequest
import dev.murugi.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/login")
    suspend fun login(@Body LoginRequest:LoginRequest): Response<LoginResponse>
}