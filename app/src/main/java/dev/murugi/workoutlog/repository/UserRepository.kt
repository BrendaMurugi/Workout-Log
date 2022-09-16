package dev.murugi.workoutlog.repository

import dev.murugi.workoutlog.api.ApiClient
import dev.murugi.workoutlog.api.ApiInterface
import dev.murugi.workoutlog.models.LoginRequest
import dev.murugi.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest) = withContext(Dispatchers.IO){
        val response = apiClient.login(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest: RegisterRequest) = withContext(Dispatchers.IO){
        val response = apiClient.registerUser(registerRequest)
        return@withContext response
    }
}