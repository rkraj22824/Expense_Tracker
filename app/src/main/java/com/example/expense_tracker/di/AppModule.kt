package com.example.expense_tracker.di




import com.example.expense_tracker.data.repository.AuthRepositoryImp
import com.example.expense_tracker.domain.repository.AuthRepository
import com.example.expense_tracker.domain.usecase.AuthUseCase
import com.example.expense_tracker.domain.usecase.GetCurrentUseCase
import com.example.expense_tracker.domain.usecase.LoginUseCase
import com.example.expense_tracker.domain.usecase.LogoutUseCase
import com.example.expense_tracker.domain.usecase.RegisterUseCase
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule{

    @Provides
    @Singleton
    fun provideFirebaseAuth():FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideAuthRepository(fAuth : FirebaseAuth):AuthRepository = AuthRepositoryImp(fAuth)



    @Provides
    @Singleton
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase {
        return AuthUseCase(
            getCurrentUseCase = GetCurrentUseCase(authRepository),
            registerUseCase = RegisterUseCase(authRepository),
            loginUseCase = LoginUseCase(authRepository),
            logoutUseCase = LogoutUseCase(authRepository)
        )
    }

//    @Provides
//    @Singleton
//    fun providesRegisterUseCase(authRepository: AuthRepository):RegisterUseCase{
//        return RegisterUseCase(authRepository)
//    }
}
