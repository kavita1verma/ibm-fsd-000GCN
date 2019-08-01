const server = require('express').Router();
const UserService = require('../services/user.service').UserService;
const userService = new UserService();
const SecurityService = require('../services/security.service').SecurityService;
const securityService = new SecurityService();
// apis
server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'Security Service is Running'
    });
});
// sign up
server.post('/register', (rq, rs) => {
    let _user = rq.body;

    let date = new Date();
    let end_Time = date.getTime() + 3000000;

    let endTime = {
        endTime: end_Time
    }

    let code = '#' + _user.name[0] + '@' + _user.email[0] + '!';

    let varCode = {
        varcode: code
    }

    _user = Object.assign(_user, endTime, varCode);
    console.log(_user);

    userService.addUser(_user, (err, res) => {
        if (err) {
            rs.status(402).json({
                message: 'Unable to proceess the request',
                trace: err
            });
        } else {
            userService.email(rq.body);
            rs.status(200).json({
                message: 'User created successfully',
                users: res
            });
        }
    });

});


// generate new password
server.post('/password', (rq, rs) => {
    let email = rq.body.email;
    let code = rq.body.code;
    userService.fetchUser(email, (err, res) => {
        if (err) {
            rs.status(402).json({
                message: 'Unable to proceess the request',
                trace: err
            });
        } else {
            let date = new Date();
            let currtim = date.getTime();
            console.log(res[0].varcode);
            console.log(code);
            if (res[0].varcode == code) {
                if (parseInt(res[0].endTime) >= parseInt(currtim)) {
                    rs.status(200).json({
                        message: 'Verification successfull',
                        users: res
                    });
                } else {
                    rs.status(402).json({
                        message: 'Unable to proceess the request Time Limit Expired'
                    });
                }
            } else {
                rs.status(402).json({
                    message: 'Unable to proceess the request Wrong OTP'
                });
            }
        }
    });

});


server.post('/token', (rq, rs) => {
    if (rq.body.email == undefined || rq.body.password == undefined) {
        rs.status(401).json({
            message: 'Please specify valid credentials'
        });
    } else {
        userService.fetchUser(rq.body.email, rq.body.password, (err, res) => {
            if (err) {
                rs.status(401).json({
                    message: 'Please specify valid credentials'
                });
            } else {
                if (res) {
                    // generate jwt token
                    const _token = securityService.generateToken(rq.body.email);
                    const _user = {
                        id: 1,
                        token: _token,
                        email: rq.body.email,
                        permission: rq.body.permission
                    }
                    securityService.saveToken(_user, (err, data) => {
                        if (err) {
                            rs.status(401).json({
                                message: 'Unable to process your request'
                            });
                        } else {
                            rs.status(200).json({
                                message: 'Token Generated Successfully',
                                token: _token
                            });
                        }
                    });
                } else {
                    rs.status(401).json({
                        message: 'Please specify valid credentials'
                    });
                }
            }
        });
    }
});

server.post('/token/refresh', (rq, rs) => {
    if (rq.body.token == undefined) {
        rs.status(401).json({
            message: 'Please specify a valid token'
        });
    } else {
        securityService.refreshToken(rq.body.token, (err, data) => {
            if (err) {
                rs.status(403).json({
                    message: 'Token expired or Invalid'
                });
            } else {
                // generate jwt token
                const _token = securityService.generateToken(data.email);
                const _user = {
                    id: 1,
                    token: _token,
                    email: data.email
                }
                securityService.saveToken(_user, (err, data) => {
                    if (err) {
                        rs.status(401).json({
                            message: 'Unable to process your request'
                        });
                    } else {
                        rs.status(200).json({
                            message: 'Token refreshed Successfully',
                            refreshToken: _token
                        });
                    }
                });
            }
        });
    }
});
// redirect in case of invalid / no access
server.get('/unauthorize', (rq, rs) => {
    rs.status(403).json({
        message: 'Unauthorize Access'
    });
});

module.exports = {
    server
}