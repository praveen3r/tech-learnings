import jwt from 'jsonwebtoken';
import 'dotenv/config';

export function generateToken(payload: any) {
    return jwt.sign(payload, process.env.JWT_SECRET!.toString(), { expiresIn: '30d'});
}