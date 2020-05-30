--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
                          `id` bigint(20) NOT NULL,
                          `cancelled_order` bit(1) NOT NULL,
                          `date` datetime DEFAULT NULL,
                          `delivery_method` varchar(255) DEFAULT NULL,
                          `total_amount` double NOT NULL,
                          `client_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FK17yo6gry2nuwg2erwhbaxqbs9` (`client_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `orders`
--
ALTER TABLE `orders`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
