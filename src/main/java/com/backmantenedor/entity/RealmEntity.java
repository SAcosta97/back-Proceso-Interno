package com.backmantenedor.entity;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name ="realm", schema = "public")
public class RealmEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private String id;

    @Column(name = "access_code_lifespan")
    private String access;

    @Column(name = "user_action_lifespan")
    private String userAction;

    @Column(name = "access_token_lifespan")
    private String accessToken;

    @Column(name = "account_theme")
    private String account;

    @Column(name = "admin_theme")
    private String adminTheme;

    @Column(name = "email_theme")
    private String emailTheme;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "events_enabled")
    private Boolean eventsEnable;

    @Column(name = "events_expiration")
    private Long eventsExpiration;

    @Column(name = "login_theme")
    private String loginTheme;

    @Column(name = "name")
    private String name;

    @Column(name = "not_before")
    private String notBefore;

    @Column(name = "password_policy")
    private String passwordPolicy;

    @Column(name = "registration_allowed")
    private Boolean registrationAllowed;

    @Column(name = "remember_me")
    private Boolean rememberMe;

    @Column(name = "reset_password_allowed")
    private Boolean resetPasswordAllowed;

    @Column(name = "social")
    private Boolean social;

    @Column(name = "ssl_required")
    private String ssl_Required;

    @Column(name = "sso_idle_timeout")
    private String ssoIdleTimeout;

    @Column(name = "sso_max_lifespan")
    private String ssoMaxLifespan;

    @Column(name = "update_profile_on_soc_login")
    private Boolean updateProfileOnSocLogin;

    @Column(name = "verify_email")
    private Boolean verifyEmail;

    @Column(name = "master_admin_client")
    private String masterAdminClient;

    @Column(name = "login_lifespan")
    private String loginLifespan;

    @Column(name = "internationalization_enabled")
    private Boolean internationalizationEnabled;

    @Column(name = "default_locale")
    private String defaultLocale;

    @Column(name = "reg_email_as_username")
    private Boolean regEmailAsUsername;

    @Column(name = "admin_events_enabled")
    private Boolean adminEventsEnabled;

    @Column(name = "admin_events_details_enabled")
    private Boolean adminEventsDetailsEnabled;

    @Column(name = "edit_username_allowed")
    private Boolean editUsernameAllowed;

    @Column(name = "otp_policy_counter")
    private String otpPolicyCounter;

    @Column(name = "otp_policy_window")
    private String otpPolicyWindows;

    @Column(name = "otp_policy_period")
    private String otpPolicyPeriod;

    @Column(name = "otp_policy_digits")
    private String otpPolicyDigits;

    @Column(name = "otp_policy_alg")
    private String otpPolicyAlg;

    @Column(name = "otp_policy_type")
    private String otpPolicyType;

    @Column(name = "browser_flow")
    private String browserFlow;

    @Column(name = "registration_flow")
    private String registrationFlow;

    @Column(name = "direct_grant_flow")
    private String directGrantFlow;

    @Column(name = "reset_credentials_flow")
    private String resetCredentialsFlow;

    @Column(name = "client_auth_flow")
    private String clientAuthFlow;

    @Column(name = "offline_session_idle_timeout")
    private String offlineSessionIdleTimeout;

    @Column(name = "revoke_refresh_token")
    private Boolean revokeRefreshToken;

    @Column(name = "access_token_life_implicit")
    private String accessTokenLifeImplicit;

    @Column(name = "login_with_email_allowed")
    private Boolean loginWithemailallowed;

    @Column(name = "duplicate_emails_allowed")
    private Boolean duplicateEmailsAllowed;

    @Column(name = "docker_auth_flow")
    private String dockerAuthFlow;

    @Column(name = "refresh_token_max_reuse")
    private String refreshTokenMaxReuse;

    @Column(name = "allow_user_managed_access")
    private Boolean allowUserManagedAccess;

    @Column(name = "sso_max_lifespan_remember_me")
    private String ssoMaxLifespanRememberMe;

    @Column(name = "sso_idle_timeout_remember_me")
    private String ssIdleTimeoutRememberMe;

    @Column(name = "default_role")
    private String defaultRole;

    //uno a Muchos
    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "realmEntity")
//    @org.springframework.lang.Nullable
    private Set<UserEntity> userEntity = new HashSet<>();




    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getUserAction() {
        return userAction;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAdminTheme() {
        return adminTheme;
    }

    public void setAdminTheme(String adminTheme) {
        this.adminTheme = adminTheme;
    }

    public String getEmailTheme() {
        return emailTheme;
    }

    public void setEmailTheme(String emailTheme) {
        this.emailTheme = emailTheme;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEventsEnable() {
        return eventsEnable;
    }

    public void setEventsEnable(Boolean eventsEnable) {
        this.eventsEnable = eventsEnable;
    }

    public Long getEventsExpiration() {
        return eventsExpiration;
    }

    public void setEventsExpiration(Long eventsExpiration) {
        this.eventsExpiration = eventsExpiration;
    }

    public String getLoginTheme() {
        return loginTheme;
    }

    public void setLoginTheme(String loginTheme) {
        this.loginTheme = loginTheme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }

    public String getPasswordPolicy() {
        return passwordPolicy;
    }

    public void setPasswordPolicy(String passwordPolicy) {
        this.passwordPolicy = passwordPolicy;
    }

    public Boolean getRegistrationAllowed() {
        return registrationAllowed;
    }

    public void setRegistrationAllowed(Boolean registrationAllowed) {
        this.registrationAllowed = registrationAllowed;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public Boolean getResetPasswordAllowed() {
        return resetPasswordAllowed;
    }

    public void setResetPasswordAllowed(Boolean resetPasswordAllowed) {
        this.resetPasswordAllowed = resetPasswordAllowed;
    }

    public Boolean getSocial() {
        return social;
    }

    public void setSocial(Boolean social) {
        this.social = social;
    }

    public String getSsl_Required() {
        return ssl_Required;
    }

    public void setSsl_Required(String ssl_Required) {
        this.ssl_Required = ssl_Required;
    }

    public String getSsoIdleTimeout() {
        return ssoIdleTimeout;
    }

    public void setSsoIdleTimeout(String ssoIdleTimeout) {
        this.ssoIdleTimeout = ssoIdleTimeout;
    }

    public String getSsoMaxLifespan() {
        return ssoMaxLifespan;
    }

    public void setSsoMaxLifespan(String ssoMaxLifespan) {
        this.ssoMaxLifespan = ssoMaxLifespan;
    }

    public Boolean getUpdateProfileOnSocLogin() {
        return updateProfileOnSocLogin;
    }

    public void setUpdateProfileOnSocLogin(Boolean updateProfileOnSocLogin) {
        this.updateProfileOnSocLogin = updateProfileOnSocLogin;
    }

    public Boolean getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(Boolean verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public String getMasterAdminClient() {
        return masterAdminClient;
    }

    public void setMasterAdminClient(String masterAdminClient) {
        this.masterAdminClient = masterAdminClient;
    }

    public String getLoginLifespan() {
        return loginLifespan;
    }

    public void setLoginLifespan(String loginLifespan) {
        this.loginLifespan = loginLifespan;
    }

    public Boolean getInternationalizationEnabled() {
        return internationalizationEnabled;
    }

    public void setInternationalizationEnabled(Boolean internationalizationEnabled) {
        this.internationalizationEnabled = internationalizationEnabled;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public Boolean getRegEmailAsUsername() {
        return regEmailAsUsername;
    }

    public void setRegEmailAsUsername(Boolean regEmailAsUsername) {
        this.regEmailAsUsername = regEmailAsUsername;
    }

    public Boolean getAdminEventsEnabled() {
        return adminEventsEnabled;
    }

    public void setAdminEventsEnabled(Boolean adminEventsEnabled) {
        this.adminEventsEnabled = adminEventsEnabled;
    }

    public Boolean getAdminEventsDetailsEnabled() {
        return adminEventsDetailsEnabled;
    }

    public void setAdminEventsDetailsEnabled(Boolean adminEventsDetailsEnabled) {
        this.adminEventsDetailsEnabled = adminEventsDetailsEnabled;
    }

    public Boolean getEditUsernameAllowed() {
        return editUsernameAllowed;
    }

    public void setEditUsernameAllowed(Boolean editUsernameAllowed) {
        this.editUsernameAllowed = editUsernameAllowed;
    }

    public String getOtpPolicyCounter() {
        return otpPolicyCounter;
    }

    public void setOtpPolicyCounter(String otpPolicyCounter) {
        this.otpPolicyCounter = otpPolicyCounter;
    }

    public String getOtpPolicyWindows() {
        return otpPolicyWindows;
    }

    public void setOtpPolicyWindows(String otpPolicyWindows) {
        this.otpPolicyWindows = otpPolicyWindows;
    }

    public String getOtpPolicyPeriod() {
        return otpPolicyPeriod;
    }

    public void setOtpPolicyPeriod(String otpPolicyPeriod) {
        this.otpPolicyPeriod = otpPolicyPeriod;
    }

    public String getOtpPolicyDigits() {
        return otpPolicyDigits;
    }

    public void setOtpPolicyDigits(String otpPolicyDigits) {
        this.otpPolicyDigits = otpPolicyDigits;
    }

    public String getOtpPolicyAlg() {
        return otpPolicyAlg;
    }

    public void setOtpPolicyAlg(String otpPolicyAlg) {
        this.otpPolicyAlg = otpPolicyAlg;
    }

    public String getOtpPolicyType() {
        return otpPolicyType;
    }

    public void setOtpPolicyType(String otpPolicyType) {
        this.otpPolicyType = otpPolicyType;
    }

    public String getBrowserFlow() {
        return browserFlow;
    }

    public void setBrowserFlow(String browserFlow) {
        this.browserFlow = browserFlow;
    }

    public String getRegistrationFlow() {
        return registrationFlow;
    }

    public void setRegistrationFlow(String registrationFlow) {
        this.registrationFlow = registrationFlow;
    }

    public String getDirectGrantFlow() {
        return directGrantFlow;
    }

    public void setDirectGrantFlow(String directGrantFlow) {
        this.directGrantFlow = directGrantFlow;
    }

    public String getResetCredentialsFlow() {
        return resetCredentialsFlow;
    }

    public void setResetCredentialsFlow(String resetCredentialsFlow) {
        this.resetCredentialsFlow = resetCredentialsFlow;
    }

    public String getClientAuthFlow() {
        return clientAuthFlow;
    }

    public void setClientAuthFlow(String clientAuthFlow) {
        this.clientAuthFlow = clientAuthFlow;
    }

    public String getOfflineSessionIdleTimeout() {
        return offlineSessionIdleTimeout;
    }

    public void setOfflineSessionIdleTimeout(String offlineSessionIdleTimeout) {
        this.offlineSessionIdleTimeout = offlineSessionIdleTimeout;
    }

    public Boolean getRevokeRefreshToken() {
        return revokeRefreshToken;
    }

    public void setRevokeRefreshToken(Boolean revokeRefreshToken) {
        this.revokeRefreshToken = revokeRefreshToken;
    }

    public String getAccessTokenLifeImplicit() {
        return accessTokenLifeImplicit;
    }

    public void setAccessTokenLifeImplicit(String accessTokenLifeImplicit) {
        this.accessTokenLifeImplicit = accessTokenLifeImplicit;
    }

    public Boolean getLoginWithemailallowed() {
        return loginWithemailallowed;
    }

    public void setLoginWithemailallowed(Boolean loginWithemailallowed) {
        this.loginWithemailallowed = loginWithemailallowed;
    }

    public Boolean getDuplicateEmailsAllowed() {
        return duplicateEmailsAllowed;
    }

    public void setDuplicateEmailsAllowed(Boolean duplicateEmailsAllowed) {
        this.duplicateEmailsAllowed = duplicateEmailsAllowed;
    }

    public String getDockerAuthFlow() {
        return dockerAuthFlow;
    }

    public void setDockerAuthFlow(String dockerAuthFlow) {
        this.dockerAuthFlow = dockerAuthFlow;
    }

    public String getRefreshTokenMaxReuse() {
        return refreshTokenMaxReuse;
    }

    public void setRefreshTokenMaxReuse(String refreshTokenMaxReuse) {
        this.refreshTokenMaxReuse = refreshTokenMaxReuse;
    }

    public Boolean getAllowUserManagedAccess() {
        return allowUserManagedAccess;
    }

    public void setAllowUserManagedAccess(Boolean allowUserManagedAccess) {
        this.allowUserManagedAccess = allowUserManagedAccess;
    }

    public String getSsoMaxLifespanRememberMe() {
        return ssoMaxLifespanRememberMe;
    }

    public void setSsoMaxLifespanRememberMe(String ssoMaxLifespanRememberMe) {
        this.ssoMaxLifespanRememberMe = ssoMaxLifespanRememberMe;
    }

    public String getSsIdleTimeoutRememberMe() {
        return ssIdleTimeoutRememberMe;
    }

    public void setSsIdleTimeoutRememberMe(String ssIdleTimeoutRememberMe) {
        this.ssIdleTimeoutRememberMe = ssIdleTimeoutRememberMe;
    }

    public String getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(String defaultRole) {
        this.defaultRole = defaultRole;
    }

    @org.springframework.lang.Nullable
    public Set<UserEntity> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(@org.springframework.lang.Nullable Set<UserEntity> userEntity) {
        this.userEntity = userEntity;
    }
}
