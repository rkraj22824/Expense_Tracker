package com.example.expense_tracker.di

import com.example.expense_tracker.data.repository.AddTransactionRepositoryImp
import com.example.expense_tracker.data.repository.AllTransactionRepositoryImp
import com.example.expense_tracker.data.repository.AuthRepositoryImp
import com.example.expense_tracker.data.repository.ProfileRepositoryImp
import com.example.expense_tracker.domain.repository.AddTransactionRepository
import com.example.expense_tracker.domain.repository.AllTransactionRepository
import com.example.expense_tracker.domain.repository.AuthRepository
import com.example.expense_tracker.domain.repository.ProfileRepository
import com.example.expense_tracker.domain.usecase.AddTransactionUseCase
import com.example.expense_tracker.domain.usecase.AllTransactionUseCase
import com.example.expense_tracker.domain.usecase.AuthUseCase
import com.example.expense_tracker.domain.usecase.LoginUseCase
import com.example.expense_tracker.domain.usecase.RegisterUseCase
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(fAuth: FirebaseAuth, fStore: FirebaseFirestore): AuthRepository =
        AuthRepositoryImp(fAuth, fStore)

    @Provides
    @Singleton
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase {
        return AuthUseCase(
            registerUseCase = RegisterUseCase(authRepository),
            loginUseCase = LoginUseCase(authRepository)
        )
    }

    @Provides
    @Singleton
    fun provideGetProfileRepository(
        fAuth: FirebaseAuth,
        fStore: FirebaseFirestore
    ): ProfileRepository = ProfileRepositoryImp(fAuth, fStore)

    @Provides
    @Singleton
    fun providesAddTransactionRepository(
        fAuth: FirebaseAuth,
        fStore: FirebaseFirestore
    ): AddTransactionRepository = AddTransactionRepositoryImp(fAuth, fStore)

    @Provides
    @Singleton
    fun providesAddTransactionUseCase(addTransactionRepository: AddTransactionRepository): AddTransactionUseCase =
        AddTransactionUseCase(addTransactionRepository)

    @Provides
    @Singleton
    fun provideAllTransactionRepository(
        fStore: FirebaseFirestore
    ): AllTransactionRepository = AllTransactionRepositoryImp( fStore)

    @Provides
    @Singleton
    fun provideAllTransactionUseCase(allTransactionRepository: AllTransactionRepository): AllTransactionUseCase =
        AllTransactionUseCase(allTransactionRepository)

}