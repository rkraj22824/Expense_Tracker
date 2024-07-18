package com.example.expense_tracker.di



import com.example.expense_tracker.data.repository.RegisterRepositroyImp
import com.example.expense_tracker.domain.repository.RegisterRepository
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
    fun provideFirebaseAuth():FirebaseAuth=Firebase.auth

    @Provides
    @Singleton
    fun provideRegisterRepository(fAuth:FirebaseAuth):RegisterRepositroyImp=RegisterRepositroyImp(fAuth)

}