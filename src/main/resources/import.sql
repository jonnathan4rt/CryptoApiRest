-- Insertar datos en la tabla Exchange
INSERT INTO exchange(id, name, location, num_crypto, base_user) VALUES(1, 'Binance', 'Hong Kong', 1550, 23000000);
INSERT INTO exchange(id, name, location, num_crypto, base_user) VALUES(2, 'Coinbase', 'San Francisco', 90, 13000000);
INSERT INTO exchange(id, name, location, num_crypto, base_user) VALUES(3, 'Kraken', 'San Francisco', 60, 8000000);
INSERT INTO exchange(id, name, location, num_crypto, base_user) VALUES(4, 'Bitstamp', 'Luxembourg', 30, 5000000);
INSERT INTO exchange(id, name, location, num_crypto, base_user) VALUES(5, 'Gemini', 'New York', 25, 3500000);

-- Insertar datos en la tabla Cryptocurrency
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(1, 'Bitcoin', 'BTC', 45000.75, 1200000, 8000000, 1);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(2, 'Ethereum', 'ETH', 3200.50, 450000, 4000000, 1);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(3, 'Cardano', 'ADA', 2.15, 80000, 2000000, 2);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(4, 'Solana', 'SOL', 150.30, 200000, 3000000, 2);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(5, 'Ripple', 'XRP', 1.25, 60000, 1500000, 3);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(6, 'Chainlink', 'LINK', 30.75, 90000, 1200000, 3);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(7, 'Polkadot', 'DOT', 25.20, 70000, 1000000, 4);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(8, 'Dogecoin', 'DOGE', 0.30, 30000, 800000, 4);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(9, 'Avalanche', 'AVAX', 60.90, 18000, 900000, 5);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(10, 'Uniswap', 'UNI', 25.10, 50000, 700000, 5);
INSERT INTO cryptocurrency(id, name, symbol, price, cap_maker, volume, id_exchange) VALUES(11, 'Litecoin', 'LTC', 160.50, 22000, 1200000, 1);
